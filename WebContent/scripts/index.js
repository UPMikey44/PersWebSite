        // Wait for the page to load first
        window.onload = function() {          
        	var fun = document.getElementById("about");

          //Set code to run when the link is clicked
          // by assigning a function to "onclick"
          fun.onclick = function() {

        	  $("#maincontent").load("fun/main.html");

            //If you don't want the link to actually 
            // redirect the browser to another page,
            // "google.com" in our example here, then
            // return false at the end of this block.
            // Note that this also prevents event bubbling,
            // which is probably what we want here, but won't 
            // always be the case.
            return false;
          };
          
          var aca = document.getElementById("academics");

          //Set code to run when the link is clicked
          // by assigning a function to "onclick"
          aca.onclick = function() {

        	  $("#maincontent").load("academics/main.html");

            //If you don't want the link to actually 
            // redirect the browser to another page,
            // "google.com" in our example here, then
            // return false at the end of this block.
            // Note that this also prevents event bubbling,
            // which is probably what we want here, but won't 
            // always be the case.
            return false;
          };
          
          var work = document.getElementById("work");

          //Set code to run when the link is clicked
          // by assigning a function to "onclick"
          work.onclick = function() {

        	  $("#maincontent").load("work/main.html");

            //If you don't want the link to actually 
            // redirect the browser to another page,
            // "google.com" in our example here, then
            // return false at the end of this block.
            // Note that this also prevents event bubbling,
            // which is probably what we want here, but won't 
            // always be the case.
            return false;
          };
          
      	var fun = document.getElementById("about1");

        //Set code to run when the link is clicked
        // by assigning a function to "onclick"
        fun.onclick = function() {

      	  $("#maincontent").load("fun/main.html");

          //If you don't want the link to actually 
          // redirect the browser to another page,
          // "google.com" in our example here, then
          // return false at the end of this block.
          // Note that this also prevents event bubbling,
          // which is probably what we want here, but won't 
          // always be the case.
          return false;
        };
        
        var aca = document.getElementById("academics1");

        //Set code to run when the link is clicked
        // by assigning a function to "onclick"
        aca.onclick = function() {

      	  $("#maincontent").load("academics/main.html");

          //If you don't want the link to actually 
          // redirect the browser to another page,
          // "google.com" in our example here, then
          // return false at the end of this block.
          // Note that this also prevents event bubbling,
          // which is probably what we want here, but won't 
          // always be the case.
          return false;
        };
        
        var work = document.getElementById("work1");

        //Set code to run when the link is clicked
        // by assigning a function to "onclick"
        work.onclick = function() {

      	  $("#maincontent").load("work/main.html");

          //If you don't want the link to actually 
          // redirect the browser to another page,
          // "google.com" in our example here, then
          // return false at the end of this block.
          // Note that this also prevents event bubbling,
          // which is probably what we want here, but won't 
          // always be the case.
          return false;
        };
        
        var work = document.getElementById("resume");

        //Set code to run when the link is clicked
        // by assigning a function to "onclick"
        work.onclick = function() {

      	  $("#maincontent").load("work/michaelresumepage.html");

          //If you don't want the link to actually 
          // redirect the browser to another page,
          // "google.com" in our example here, then
          // return false at the end of this block.
          // Note that this also prevents event bubbling,
          // which is probably what we want here, but won't 
          // always be the case.
          return false;
        };
 
        var work = document.getElementById("resume1");

        //Set code to run when the link is clicked
        // by assigning a function to "onclick"
        work.onclick = function() {

      	  $("#maincontent").load("work/michaelresumepage.html");

          //If you don't want the link to actually 
          // redirect the browser to another page,
          // "google.com" in our example here, then
          // return false at the end of this block.
          // Note that this also prevents event bubbling,
          // which is probably what we want here, but won't 
          // always be the case.
          return false;
        };        
    };