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

   function checkAllOffDay(obj){
	
	   var off=document.getElementById("centreContentForm:shift_off").value();
	   var count=0;
	   if(obj.checked){
           $(".booleanCheckBox").each(function()
       	      {  
//        	    if( $(this).prop('disabled')==false)       
        	          $(this).prop('checked', true);
        	          count++;
       		   });
             if(count>off)
	    	    {
	    	      alert("Please do not select More than number of week off");
	    	      $(this).prop('checked', false);
	    	    }
           } 
	       
	   
//	      else {
//	    	  $(".checkBoxClass").each(function()
//	    	      {  
//	    	         $(this).prop('checked', false); 
//	    	      });
//	          };
     
   };
   
   function inputNumber(obj)
      {
	      if(isNaN(obj.value))
	         {
	    	    alert("Please Enter Only Number");
	    	    obj.value="";
	    	    return false;
	    	  }
	      else
	    	   return true;
	   
      }
   
   function maxTextAreaCharacter(obj)
       {
	       var val=obj.value;
	        if(val.length>100)
	          {
	        	 alert("Do not Enter more than 100 Character");
	        	 obj.value=val.substr(0,100);  
	        	 return false;
	        	 
	           }
	        else
	        	return true;
	       
	    	   
       }
   
   function currentBusinessDate(obj,obj1)
         {
	      var curDate=new Date();
	      var selectedDate=new Date(obj.value);
	      if(selectedDate<curDate)
	         {
	    	  alert("Please Select Greater Than Today's Date");
	    	  obj.value="";
	    	  obj1.value="";
	    	  return false;
	    	  
	         }
	      else{
	    	  obj1.value="";
	    	  return true;
	       }
	     
	   
      }
   
   function selectCheckBox()
      {
	        var count=0;
	        $(".booleanCheckBox").each(function()
	       	      {        
	        	         if( $(this).prop('checked')==true)
	        	          count++;
	       		   });
	          if(count==0)
	           {
	        	 alert("Please Select atleast one Record");
	        	 return false;
	           }
	          else 
	        	{
	        	  return true; 
	        	}
	   
      }
   
   function validateDays(obj)
     {
	 
	      var toTalDays=0;
	      var days=obj.value;
	      if(isNaN(obj.value))
	    	  {
	    	    alert("Please Enter only Number"); 
	    	    obj.value="";
	    	    return false;
	    	  }
	      $(".dayInputText").each(function()
            { 
	    	  
	    	  toTalDays=toTalDays+parseFloat(this.value);
            });
	     
	  if(toTalDays>30)
 	    {
		  alert("Total Leave can not be greater than 30 days");
		  obj.value="";
		  return false;
		}
	  
      } 
   
    function validateShiftTime(){   
    	 
    	
    	 var inTimeHr=RichFaces.$("centreContentForm:shiftStartTimeDetail1").getValue(); 
    	 var inTimeMin=RichFaces.$("centreContentForm:shiftStartTimeDetail2").getValue(); 
    	 var inTimeSec=RichFaces.$("centreContentForm:shiftStartTimeDetail3").getValue();
    	 var outTimeHr=RichFaces.$("centreContentForm:shiftEndTimeDetail1").getValue(); 
    	 var outTimeMin=RichFaces.$("centreContentForm:shiftEndTimeDetail2").getValue(); 
    	 var outTimeSec=RichFaces.$("centreContentForm:shiftEndTimeDetail3").getValue();
    	 var d1=new Date(parseInt("2001",10),(parseInt("01",10))-1,parseInt("01",10),parseInt(inTimeHr,10),parseInt(inTimeMin,10),parseInt(inTimeSec,10));
    	 var d2=new Date(parseInt("2001",10),(parseInt("01",10))-1,parseInt("01",10),parseInt(outTimeHr,10),parseInt(outTimeMin,10),parseInt(outTimeSec,10));
    	 var dd1=d1.valueOf();
    	 var dd2=d2.valueOf();
    	 if(dd1>=dd2) 
    	   {   
    		 alert("Please Enter Out Time Greater Than In Time");
    		 return false;
    		
           }
    	  else{
    		  return true;
    	  }
   
    	 } 
    
    function validateBreakTime(){   
   	    
 
   	 var inTimeHr=RichFaces.$("centreContentForm:breakStartTimeDetail1").getValue(); 
   	
   	 var inTimeMin=RichFaces.$("centreContentForm:breakStartTimeDetail2").getValue();
    
   	 var inTimeSec=RichFaces.$("centreContentForm:breakStartTimeDetail3").getValue();
   	 
   	 
   	 var outTimeHr=RichFaces.$("centreContentForm:breakEndTimeDetail1").getValue(); 
   	 
     
   	 
   	 var outTimeMin=RichFaces.$("centreContentForm:breakEndTimeDetail2").getValue(); 
   	 
  	
   	 
   	 var outTimeSec=RichFaces.$("centreContentForm:breakEndTimeDetail3").getValue();
   	
   	 var d1=new Date(parseInt("2001",10),(parseInt("01",10))-1,parseInt("01",10),parseInt(inTimeHr,10),parseInt(inTimeMin,10),parseInt(inTimeSec,10));
	 var d2=new Date(parseInt("2001",10),(parseInt("01",10))-1,parseInt("01",10),parseInt(outTimeHr,10),parseInt(outTimeMin,10),parseInt(outTimeSec,10));
		
	 var dd1=d1.valueOf();
	 var dd2=d2.valueOf();
	
	 if(dd1>=dd2) 
	   {   
		 alert("Please Enter Out Time Greater Than In Time");
		 return false;
		    
       }
	  else{
	//	  disableAdd();
		  return true;
	  }

  }  
 
//    function disableAdd(){
//	      $(".addButton").prop('disabled', false);
//          $(".updateButton").prop('disabled', true); 
//     }
    
  


  