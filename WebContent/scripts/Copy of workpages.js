  //Get a reference to the link on the page
  // with an id of "mylink"
  var over = document.getElementById("over");

    //Set code to run when the link is clicked
    // by assigning a function to "onclick"
  over.onclick = function() {

  	$("#content").load("work/overview.html");
  	document.getElementById("employer").innerHTML = "Summary";

      //If you don't want the link to actually 
      // redirect the browser to another page,
      // "google.com" in our example here, then
      // return false at the end of this block.
      // Note that this also prevents event bubbling,
      // which is probably what we want here, but won't 
      // always be the case.
    return false;
  };        	
	
  var acn = document.getElementById("acn");

  //Set code to run when the link is clicked
  // by assigning a function to "onclick"
  acn.onclick = function() {

	  $("#content").load("work/accenture.html");
	  document.getElementById("employer").innerHTML = "Accenture";

    //If you don't want the link to actually 
    // redirect the browser to another page,
    // "google.com" in our example here, then
    // return false at the end of this block.
    // Note that this also prevents event bubbling,
    // which is probably what we want here, but won't 
    // always be the case.
    return false;
  };
  
  var acnusps = document.getElementById("usps");

  //Set code to run when the link is clicked
  // by assigning a function to "onclick"
  acnusps.onclick = function() {

	  $("#content").load("work/accenture.html#usps");
	  document.getElementById("employer").innerHTML = "Accenture";

    //If you don't want the link to actually 
    // redirect the browser to another page,
    // "google.com" in our example here, then
    // return false at the end of this block.
    // Note that this also prevents event bubbling,
    // which is probably what we want here, but won't 
    // always be the case.
    return false;
  };
  
  var acnlgs = document.getElementById("lgs");

  //Set code to run when the link is clicked
  // by assigning a function to "onclick"
  acnlgs.onclick = function() {

	  $("#content").load("work/accenture.html#lgs");
	  document.getElementById("employer").innerHTML = "Accenture";

    //If you don't want the link to actually 
    // redirect the browser to another page,
    // "google.com" in our example here, then
    // return false at the end of this block.
    // Note that this also prevents event bubbling,
    // which is probably what we want here, but won't 
    // always be the case.
    return false;
  };  
  
  var del = document.getElementById("del");

  //Set code to run when the link is clicked
  // by assigning a function to "onclick"
  del.onclick = function() {

	  $("#content").load("work/deloitte.html");
	  document.getElementById("employer").innerHTML = "Deloitte &amp; Touche LLC";

    //If you don't want the link to actually 
    // redirect the browser to another page,
    // "google.com" in our example here, then
    // return false at the end of this block.
    // Note that this also prevents event bubbling,
    // which is probably what we want here, but won't 
    // always be the case.
    return false;
  };
  
  var tick = document.getElementById("tick");

  //Set code to run when the link is clicked
  // by assigning a function to "onclick"
  tick.onclick = function() {

	  $("#content").load("work/tickdata.html");
	  document.getElementById("employer").innerHTML = "Tick Data";

    //If you don't want the link to actually 
    // redirect the browser to another page,
    // "google.com" in our example here, then
    // return false at the end of this block.
    // Note that this also prevents event bubbling,
    // which is probably what we want here, but won't 
    // always be the case.
    return false;
  };