fetch('http://localhost:8079/characterClasses')
    .then(res => {
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.json();
        console.log(res);
});