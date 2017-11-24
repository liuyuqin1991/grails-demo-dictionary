package dictionary

class City {

    static mapping = {
        version false
    }

    static constraints = {
        name blank:false , size:3..10 , unique:true
        countrycode blank:false , maxSize: 10
        district blank:true
        population size: 4..10 , range: 10..9999999
    }

    Integer id
    String name
    String countrycode
    String district
    Integer population
}
