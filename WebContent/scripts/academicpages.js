  //Get a reference to the link on the page
  // with an id of "mylink"
  var grad = document.getElementById("grad");

    //Set code to run when the link is clicked
    // by assigning a function to "onclick"
  grad.onclick = function() {

  	$("#content").load("academics/grad.html");

      //If you don't want the link to actually 
      // redirect the browser to another page,
      // "google.com" in our example here, then
      // return false at the end of this block.
      // Note that this also prevents event bubbling,
      // which is probably what we want here, but won't 
      // always be the case.
    return false;
  };        	
	
  var under = document.getElementById("under");

  //Set code to run when the link is clicked
  // by assigning a function to "onclick"
  under.onclick = function() {

	  $("#content").load("academics/undergrad.html");

    //If you don't want the link to actually 
    // redirect the browser to another page,
    // "google.com" in our example here, then
    // return false at the end of this block.
    // Note that this also prevents event bubbling,
    // which is probably what we want here, but won't 
    // always be the case.
    return false;
  };