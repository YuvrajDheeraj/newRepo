$('document').ready(function(){

	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(vehicleStatus,status){
			$('#idEdit').val(vehicleStatus.id);
			$('#descriptionEdit').val(vehicleStatus.description);
			$('#detailsEdit').val(vehicleStatus.details);
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
 			$.get(href,function(vehicleStatus,status){
			$('#idDetails').val(vehicleStatus.id);
			$('#descriptionDetails').val(vehicleStatus.description);
			$('#detailsDetails').val(vehicleStatus.details);
			$('#lastModifiedByDetails').val('Dheeraj');
			$('#lastModifiedDateDetails').val('26 th sep');
			});		
 			$('#detailsModal').modal();
 			});
});