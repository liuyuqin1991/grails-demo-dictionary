package dictionary

import grails.converters.JSON

class ShowDataController {

    ShowDataService showDataService

    private String cityName = "Rafah"

    def findCityById() {
        def cityId = 10
        def city = showDataService.findCityById(cityId)
        render(model:  city as JSON)
    }

    def findCityByNameAndPopulation() {
        def population = 92020
        def city = showDataService.findCityByNameAndPopulation(cityName , population)
        render(model:  city as JSON)
    }

    def findCityByNameLike() {
        def name = "G%"
        def cityList = showDataService.findCityByNameLike(name)
        render(model:  cityList as JSON)
    }

    def findAllCityByNameLike() {
        def name = "G%"
        def cityList = showDataService.findAllCityByNameLike(name)
        render(model:  cityList as JSON)
    }


    def findCityByName() {
        def cityList = showDataService.findCityByName(cityName)
        render(model:  cityList as JSON)
    }


    def saveCity(){
        def city = new City()
        city.name = "Beijing"
        city.countrycode = "USA"
        city.population = 2338263
        city.district = "West Java"
        showDataService.saveCity(city)
        render("save success")
    }

    def saveErrorCity(){
        def msg = ""
        def city = new City()
        city.name = ""
        city.countrycode = "USA"
        city.population = 2338263
        city.district = "West Java"
        if(showDataService.saveCity(city)){
            msg = "save success"
        }
        else{
            city.errors.allErrors.each {
                msg += it.defaultMessage + ","
            }
        }
        render(msg)
    }

    def deleteCity(){
        def code = "Beijing"
        showDataService.deleteCity(code)
        render("delete success")
    }

    def updateCity(){
        def code = params["city_name"]
        def cityId = 4098
        showDataService.updateCity(cityId , code)
        render("update success")
    }


}
