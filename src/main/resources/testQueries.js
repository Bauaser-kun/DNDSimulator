async function populateTableWithPulledData(url, table) {
    const tableHead = table.querySelector("thead");
    const tableBody = table.querySelector("tbody");
    const response = await fetch(url);
    const data = await response.json();
    const columns = Object.keys(data[0]);

    //clearTable
    tableHead.innerHTML = "<tr></tr>";
    tableBody.innerHTML = "";

    //Assign headers
    for (const column of columns) {
        const headerElement = document.createElement("th");
        headerElement.className = "classHeaderCell";
        headerElement.textContent = column;
        tableHead.querySelector("tr").appendChild(headerElement);
    }

    //assign rows
    for (let i = 0; i < data.length; i++) {
        const bodyRow = document.createElement("tr");
        const row = Object.values(data[i]);

        //assign cells
        for (const cell of row) {
            const cellElement = document.createElement("td");
            cellElement.className = "classRowCell"; 
            cellElement.textContent = cell;
            bodyRow.appendChild(cellElement);
        }

        tableBody.appendChild(bodyRow);
    }
}

function getAllClasses() {
    populateTableWithPulledData('http://localhost:8079/classes/getCharacterClasses', document.querySelector("table"));
}

getAllClasses();