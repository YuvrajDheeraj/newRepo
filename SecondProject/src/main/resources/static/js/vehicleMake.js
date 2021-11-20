$('document').ready(function(){

	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(vehicleMake,status){
			$('#idEdit').val(vehicleMake.id);
			$('#descriptionEdit').val(vehicleMake.description);
			$('#detailsEdit').val(vehicleMake.details);
			});		
	 	$('#editModal').modal();
 });
 
		 		$('table #deleteButton').on('click',function(event){
				event.preventDefault();
				var href=$(this).attr('href');
				$('#confirmDeleteButton').attr('href',href);
				 $('#deleteModal').modal();
				 });
 
 		
 		$('table #detailsButton').on('click',function(event){
 			event.preventDefault();
 			var href=$(this).attr('href');
 			$.get(href,function(vehicleMake,status){
			$('#idDetails').val(vehicleMake.id);
			$('#descriptionDetails').val(vehicleMake.description);
			$('#detailsDetails').val(vehicleMake.details);
			$('#lastModifiedByDetails').val('Dheeraj');
			$('#lastModifiedDateDetails').val('26 th sep');
			});		
 			$('#detailsModal').modal();
 			});
});