

function openBookWindow(hotelId, hotel) {
    // Set the hotelIdInput field's value with the selected hotel ID
    document.getElementById("hotelId").value = hotelId;

    // Update the content of the selectedHotel element
    document.getElementById("selectedHotel").textContent =  hotel;

    // Show the book window
    openPopup('book-window');
}


//show and hide popup 
function openPopup(id) {
  document.getElementById(id).style.display = "flex";
}
   
function closePopup(id) {
  document.getElementById(id).style.display = "none";
}
