define([       	    
	    'applications',
	    'applicationsView'
	    ], 
        function(        	
        		Applications,
        		applicationsView
        ) {	
			
	//  ****************************  ИНИЦИАЛИЗАЦИЯ ПРИЛОЖЕНИЯ ********************************************	
			
	//Создаем модели и коллекции для работы с данными
	app.applications = new App.Collections.Applications();       //создаем коллекцию справочных данных	
	app.applications.fetch();
	
	app.mpg = new App.Views.applicationsView({collection: app.applications, parentpaggrid: '#mainGridPlace'});	
	
	//---------------------------------------------------------------------------------------------------------------------------------------------  	
	console.log("Приложение загружено успешно");
  }
);

