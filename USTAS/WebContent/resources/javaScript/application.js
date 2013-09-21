function checkEmail(obj) {
    var email =obj; 
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!filter.test(email.value)) {
    alert('Please provide a valid email address');
    obj.value="";
    obj.focus();
      return false;
     }
    return true;
}  


      $(".inputText").focus(function (){  
    	   
    	  
    	  $(this).css("background-color","#FFEEAA");
    	  $(this).css("border","2px solid #AA88FF");
    	  $(this).blur(function (){
    		  $(this).css("background-color","");
    		  $(this).css("border","");
    		
    	     });
     });
      
 function checkAllCheckboxesInTable(obj){
	   if(obj.checked){
           $(".checkBoxClass").each(function()
       	      {  
        	    if( $(this).prop('disabled')==false)       
        	          $(this).prop('checked', true); 
       		   });
             }  
	      else {
	    	  $(".checkBoxClass").each(function()
	    	      {  
	    	         $(this).prop('checked', false); 
	    	      });
	          };
     
   };
   
   function checkDates(d1, d2) {
	         alert("Hi");
	    if (d1 instanceof Date && d2 instanceof Date) {
	        var today = new Date();
	        today.setHours(0, 0, 0, 0);
	        if (date1.getTime() < (today.getTime() + 86400000)) {
	            return "First date should be after today";
	        }
	        if (date2.getTime() < (date1.getTime() + 86400000)) {
	            return "Second date should be after First date";
	        }
	        return "Dates are valid";
	    }
	    return "One or more invalid date";
	}

   function checkDates1()
   {
	   alert("Hi");
   }
  


  