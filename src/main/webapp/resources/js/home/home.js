var HomeComponent = React.createClass({
	componentWillMount: function(){
		console.log("Hello World")
	}
	,
	render: function(){
		return (<h1>Hello Home</h1>);
	}
});

ReactDOM.render(
		<HomeComponent />,
		document.getElementById('home')
);