package invoices

import grails.converters.JSON;

class InvoiceController {
	
	def invoiceService    
	
	def add () {        
		render invoiceService.add (params) as JSON    
	}
	
	def all () {        
		def invoices = invoiceService.all ()        
		render invoices as JSON    
	}
}
