async function populateTableWithPulledData(url, table) {
    const tableHead = table.querySelector("thead");
    const tableBody = table.querySelector("tbody");
    const response = await fetch(url);
    const data = await response.json();
    const columns = Object.keys(data[0]);

    //clearTable
    tableHead.innerHTML = "<tr></tr>";
    tableBody.innerHTML = "";

    for (const column of columns) {
        const headerElement = document.createElement("th");
        headerElement.textContent = column;
        tableHead.querySelector("tr").appendChild(headerElement);
    }

    for (let i = 0; i < data.length; i++) {
        const bodyRow = document.createElement("tr");
        const row = Object.values(data[i]);

        for (const cell of row) {
            const cellElement = document.createElement("td");
            cellElement.textContent = cell;
            bodyRow.appendChild(cellElement);
        }

        tableBody.appendChild(bodyRow);
    }
}

function getAllClasses() {
    populateTableWithPulledData('http://localhost:8079/classes/getCharacterClasses', document.querySelector("table"));
}