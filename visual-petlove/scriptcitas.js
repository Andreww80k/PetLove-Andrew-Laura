document.getElementById("submitBtn").addEventListener("click", function() {
    var selectedDate = document.getElementById("datePicker").value;
    var selectedTime = document.getElementById("timePicker").value;

    document.getElementById("confirmedDate").textContent = selectedDate;
    document.getElementById("confirmedTime").textContent = selectedTime;

    document.getElementById("calendar").classList.add("hidden");
    document.getElementById("confirmation").classList.remove("hidden");
});