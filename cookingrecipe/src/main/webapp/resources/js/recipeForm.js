$(document).ready(function(){
var i=1;
  $(".add-step").click(function(){
	  $(".steps").before(`<div class="step-card">
					  		<label for="step">
				  			<span>Step</span>
				  			<span>${i}</span>
				  		</label>
				    	<input type="text" class="form-control" placeholder="Input how to make" name="addstep">
				  	</div>`);
		i++;
  });
  
});
		