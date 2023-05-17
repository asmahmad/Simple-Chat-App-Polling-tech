document.addEventListener('DOMContentLoaded', () => {
  initializeUser();
});
function initializeUser() {
	let users = sessionStorage.getItem('user');
	let userx = JSON.parse(users);

	if (userx == null) {
		let username = prompt('What is your name?');
		let user = {
			'username': username
		};
		getUser(user);
	}
}
async function getUser(user) {
	try {
		let response = await fetch('/welcome', {
			method: 'POST',
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(user)
		});

		let data = await response.json();
		sessionStorage.setItem('user', JSON.stringify(data));
	} catch (error) {
		console.error(error);
	}
}
