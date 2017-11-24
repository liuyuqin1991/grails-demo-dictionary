package dictionary



class ShowDataService {

    String HQL_findCityByName = "from City where name = :cityName"

    //根据ID查找对象
    def findCityById(Integer cityId) {
        return City.findById(cityId)
    }


    //根据name与population查找对象
    def findCityByNameAndPopulation(String name , Integer population){
        return City.findByNameAndPopulation(name,population)
    }

    //根据name like 查找对象
    def findCityByNameLike(String name){
        return City.findByNameLike(name)
        //return City.findByNameILike(name) 不区分大小写的like
        //return City.findByNameRLike(name) 使用正则表达式的like
    }

    //根据name like 查找对象
    def findAllCityByNameLike(String name){
        return City.findAllByNameLike(name)
    }

    //使用HQL语句查找对象
    def findCityByName(String name){
        return City.executeQuery(HQL_findCityByName , [cityName:name])
    }


    //保存city
    def saveCity(City city){
        return city.save()
    }

    //删除city
    def deleteCity(String name){
        City city = City.findByName(name)
        return city.delete()
    }

    //修改city
    def updateCity(Integer id , String name) {
        City city = City.findById(id)
        city.name = name
        println("12312412")
    }
}
