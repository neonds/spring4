var webjars = {
    versions:{
    	'jquery': '2.2.4', 
    	'react': '15.3.2',
    	
    },
	
    path: function(webjarid, path) {
    	var scriptToLoad = 'webjars/' + webjarid + '/' + webjars.versions[webjarid] + '/' + path;
    	console.log("loading: "+scriptToLoad  +".js")
        return scriptToLoad;
    }
};

var modules = {
	
		path: function(moduleName, scriptName){
	    	var scriptToLoad = 'resources/js/' + moduleName + '/' + scriptName;
	    	console.log("loading module: "+scriptToLoad + ".js");
		}
}

require.config({
	baseUrl: '/',
	
	paths:{
	 	
		/* Vendors */
		'jquery': webjars.path('jquery', 'jquery.min'),
	 	'react': webjars.path('react', 'react'),
	 	'reactDOM': webjars.path('react', 'react-dom'),
	 	
	 	/*Components*/
	 	'homeComponent': modules.path('home', 'home'),
	}
});