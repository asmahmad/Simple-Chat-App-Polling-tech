const container = document.querySelector('.container');
const userData = sessionStorage.getItem('user');
const user = JSON.parse(userData);
const textArea = document.querySelector('textarea');
const channelId = textArea.dataset.id;
const textP = document.querySelector('#text');
let myArr = [];

// Redirect to welcome page if user data is not available
if (!userData) {
    window.location.href = 'http://localhost:8080/welcome';
}

// Fetch messages every 500ms
setInterval(fetchMessages, 500);

async function fetchMessages() {
    const response = await fetch(`/channels/${channelId}/messages`);
    const data = await response.json();
    if (data.length > myArr.length) {
        myArr = data;
        renderMessages();
    }
}

function renderMessages() {
    const p = document.createElement('p');
    p.innerHTML = myArr.map(message => `<span>${message[0]}: ${message[1]}</span><br/>`).join('');
    container.innerHTML = '';
    container.appendChild(p);
}

textArea.addEventListener('keydown', e => {
    if (e.keyCode === 13) {
        const message = textArea.value;
        const payload = {
            id: user.id,
            username: user.username,
            messages: [message],
            channelId: channelId
        };
        // Send message to server
        fetch(`/channels/${channelId}`,{
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(payload)
        }).then(response => response.json())
          .then(() => textArea.value = '');
    }
});
