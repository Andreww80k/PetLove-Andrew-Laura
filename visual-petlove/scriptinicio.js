document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Aquí puedes agregar la lógica de autenticación
    // por ejemplo, enviar los datos al servidor para verificar las credenciales
    // y redirigir al usuario a la página de inicio después de iniciar sesión exitosamente
});
