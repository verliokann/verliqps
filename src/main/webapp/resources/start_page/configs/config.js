requirejs.config({
	baseUrl: 'http://localhost:8080/cmf/resources',
	paths: { 
		"jquery"    	: 'js/jquery-3.2.1',
		"underscore"	: 'js/underscore',
		"json2"     	: 'js/json2',
		"backbone"  	: 'js/backbone',		
		"text"      	: 'js/text',			
		"backgrid"  	: 'components/backgrid-0.3.7/lib/backgrid',
		"backbone.paginator" 		: 'components/backbone.paginator-master/lib/backbone.paginator',	
		"bgpaginator"   : 'components/backgrid-paginator-master/backgrid-paginator.min',
		"bgfilter"    	: 'components/backgrid-filter-master/backgrid-filter.min',		
		"bgselectall"  	: 'components/backgrid-select-all-master/backgrid-select-all',
		
		"app"       	: 'start_page/js/main',
		"application"  	: 'start_page/js/models/application',
		"applications"  : 'start_page/js/collections/applications',
		"applicationsView"  : 'start_page/js/views/applications',

	},	
	shim: {
		 underscore: {
		 exports: "_"
		 },
		 backbone: {
		  deps: ["jquery", "underscore", "json2"],
		  exports: "Backbone"
		 } 
	},			 
	waitSeconds: 15
 });


//Стартуем клиентское приложение после его загрузки 
require(['app']);

