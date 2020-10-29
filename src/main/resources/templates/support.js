class SearchFunction{
    constructor(){
        this.elements={
        searchBar : document.getElementById("searchBar"),
        searchBtn : document.getElementById("searchBtn"),
        dataTable : document.getElementById("dataTable")
        }
        this.loadHomePage()
        this.assignOnClickMethods()
        console.log("JS started execution")
    }
    fillTable(record){
    var row=this.dataTable.insertRow(0)
    var cell1=row.insertRow(0)
    cell1.innerHTML=`${record.FIPS}`
    var cell2=row.insertRow(1)
    cell2.innerHTML=`${record.Admin2}`
    var cell3=row.insertRow(2)
    cell3.innerHTML=`${record.Province_State}`
    var cell4=row.insertRow(3)
    cell4.innerHTML=`${record.Country_Region}`
    var cell5=row.insertRow(4)
    cell5.innerHTML=`${record.Confirmed}`
    var cell6=row.insertRow(5)
    cell6.innerHTML=`${record.Deaths}`
    var cell7=row.insertRow(6)
    cell7.innerHTML=`${record.Recovered}`
    var cell8=row.insertRow(7)
    cell8.innerHTML=`${record.Active}`
    var cell9=row.insertRow(8)
    cell9.innerHTML=`${record.Combined_Key}`
    var cell10=row.insertRow(9)
    cell10.innerHTML=`${record.Incidence_Rate}`
    var cell11=row.insertRow(10)
    cell11.innerHTML=`${record.CaseToFatality_Ratio}`
    }

    loadHomePage(){
            const userAction = async () => {
              const response = await fetch('localhost:8080');
              console.log(response)
              const myJson = await response.json(); //extract JSON from the http response
              // do something with myJson
              for (res in myJson){
                    this.fillTable(res)
              }
            }
    }
    assignOnClickMethods(){
    this.elements.searchBtn.addEventListener('click',(event)=>{
        var query= this.elements.searchBar.value
          const userAction = async () => {
                        const response = await fetch(`localhost:8080/search/${query}`);
                        console.log(response)
                        const myJson = await response.json(); //extract JSON from the http response
                        // do something with myJson
                        for (res in myJson){
                              this.fillTable(res)
                        }
                      }
    })
    }
}

new SearchFunction()