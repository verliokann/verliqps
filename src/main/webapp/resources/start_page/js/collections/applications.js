define(['application'], function(Application){
	
	App.Collections.Applications = Backbone.Collection.extend({
		   model: Application,		  
		   initialize: function () {
			    
		        this.on('add', function(model) {
					console.log("Модель добавлена в коллекцию");					
		        });
		        this.on('remove',  function(model) {
		            console.log('Модель удалена из коллекции');
		        });
		        this.on('change', function(model) {
		            console.log('Модель изменена в коллекции');
		        });
		  			
		        this.on("request", function(applicationrecu){
				    console.log("Модель отправлена на сервер");
			    });
			    
		        this.on("sync", function(applicationsync){
				console.log("Модель добавлена в БД");			
			    });
		        
		        this.comparator = function(application) {
		        	  return application.get("name");
		        };
		   },
			    
		  saveapplication: function(id_c){               	
	               	console.log("Модель по номеру ", this.get(19));			
		  },
		        
		   url: "app", 
		
		   state: {
			    pageSize: 15
		   },
		 
		   mode: "client"		    
			   
		});	

	return App.Collections.Applications;
});