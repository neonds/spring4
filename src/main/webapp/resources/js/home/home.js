require(["config"], function() {
    
	
	/**
	 * Home Component
	 */
	define('homeComponent', ['react'], function(React){
		
		
		var homeComponent = React.createClass({
			
			render: function(){
				return (<h1>Hola mundo</h1>);
			}
		});
		
		
		return homeComponent
	});
	
	
	require(['homeComponent', 'react', 'reactDOM'], function(HomeComponent, React, ReactDOM){
		
		console.log(HomeComponent);
		
		ReactDOM.render(
				<HomeComponent/>,
				document.getElementById('home')
		);
	})
	
	

});