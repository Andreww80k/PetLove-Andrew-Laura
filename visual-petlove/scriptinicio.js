document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    if (email.endsWith('@gmail.com')) {
      window.location.href = 'Cliente/clienteprincipal.html'; // Redireccionar a la página del cliente
    } else if (email.endsWith('@professionalgrooming.com')) {
      window.location.href = 'Veterinario/veterinarioprincipal.html'; // Redireccionar a la página del veterinario
    } else if (email.endsWith('@petlove.com')) {
      window.location.href = 'Admin/adminprincipal.html'; // Redireccionar a la página del administrador
    } else {
        // Si no coincide con ninguno, se puede mostrar un mensaje de error o tomar otra acción
        alert('Correo electrónico no válido');
    }
});