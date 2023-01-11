window.addEventListener("load", function(){
    // ReactDOM.render(
    //     "Hello, ReactJS!",
    //     document.getElementById("root")
    // );

    const root = ReactDOM.createRoot(
        document.getElementById('root')
    );
    root.render(<h1>Hello, world!</h1>);

})