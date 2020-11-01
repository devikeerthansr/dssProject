// Create a new snippet
$("#creator-new-snippet").click(function(e){

   if($("#info-textarea").val() == ""){
      $("#info-textarea").prop('disabled', false);
   }

   if($("#snippet-textarea").val() == ""){
      $("#snippet-textarea").prop('disabled', false);
   }

});

// Add comment
$("#add-comment").click(function(e){
   if($("#comment").val() == ""){
      $("#comment").prop('disabled', false);
   }
});

// Save comment
$("#save-comment").click(function(e){
   if(!$("#comment").val() == ""){
      $("#comment").prop('disabled', true);
   }
});

// Delete comment
$("#delete-comment").click(function(e){
   $("#comment").val("");
});


// Save info 
$("#save-info").click(function(e){
   if(!$("#info-textarea").val() == ""){
      $("#info-textarea").prop('disabled', true);
   }
});

// Save snippet
$("#save-snippet").click(function(e){
   if(!$("#snippet-textarea").val() == ""){
      $("#snippet-textarea").prop('disabled', true);
   }
});

// Edit info
$("#edit-info").click(function(e){
   $("#info-textarea").prop('disabled', false);
});

// Edit snippet
$("#edit-snippet").click(function(e){
   $("#snippet-textarea").prop('disabled', false);
});

// Delete snippet
$("#delete-snippet").click(function(e){
   $("#snippet-textarea").val("");
   $("#info-textarea").val("");
});

/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
