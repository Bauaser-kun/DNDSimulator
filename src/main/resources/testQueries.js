 $(document).ready(function() {
    var apiRoot = 'http://localhost:8079/classes/';
    var datatableRowTemplate = $('[data-datatable-row-template]').children()[0];
    var dataContainer = $('[data-class-container]');

    getAllClasses();

    function createElement(data) {
        const element = $(datatableRowTemplate).clone();
        element.attr('data-class-id', data.class)

        return element;
    }

    function getAllClasses() {
        var requestUrl = apiRoot + "getCharacterClasses";

        $.ajax({
            url: requestUrl,
            method: 'GET',
            success: handleDataTableRender
        });
    }

    function handleDataTableRender(data) {
        dataContainer.empty();
        data.forEach(function(characterClass) {
            createElement(characterClass).appendTo(dataContainer);
        });
    }


 })