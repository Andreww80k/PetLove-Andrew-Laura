document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const phone = document.getElementById('phone').value;
    const birthdate = document.getElementById('birthdate').value;
    // Aquí puedes agregar la lógica de registro
    // por ejemplo, enviar los datos al servidor para crear una nueva cuenta de usuario
    // y mostrar un mensaje de éxito o error al usuario
});
