$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$.get(href,function(invoice,status){
			$('#idEdit').val(invoice.id);
			$('#descriptionEdit').val(invoice.description);
			$('#ddlClientEdit').val(invoice.clientid);
			var invoiceDate= invoice.invoiceDate.substr(0,10);
			$('#invoiceDateEdit').val(invoice.invoiceDate);
			$('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
			$('#remarksEdit').val(invoice.remarks);
			});		
	 	$('#editModal').modal();
 });
 
		 		$('table #deleteButton').on('click',function(event){
				event.preventDefault();
				var href=$(this).attr('href');
				alert(href);
				$('#confirmDeleteButton').attr('href',href);
				 $('#deleteModal').modal();
				 });
 
 		
 		$('table #detailsButton').on('click',function(event){
 			event.preventDefault();
 			var href=$(this).attr('href');
 			$.get(href,function(invoice,status){
			$('#idDetails').val(invoice.id);
			$('#ddlClientDetails').val(invoice.clientid);
			$('#ddlInvoiceStatusDetails').val(invoice.invoicestatusid);
			var Date= invoice.invoiceDate.substr(0,10);
			$('#remarksDetails').val(invoice.remarks);
			
			$('#lastModifiedByDetails').val('Dheeraj');
			$('#lastModifiedDateDetails').val('26 th sep');
			});		
 			$('#detailsModal').modal();
 			});
});