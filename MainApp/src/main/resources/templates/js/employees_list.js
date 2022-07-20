let MainApp = angular.module('MainApp',[]);

MainApp.controller('EmployeeController', function($scope, $http){

    $http.get("http://localhost:8080/api/v1/employees")
        .then(resp => {
            $scope.employeesList = resp.data;
        },
        resp => {
            console.error(resp);
        })

    $scope.save = function(){

    }

    $scope.create  = function(employee){

    const data = JSON.stringify(employee);

    $http.post("http://localhost:8080/api/v1/employees", data)
        .then(resp =>{
            $scope.employeesList[resp.data.employeeId] = resp.data;
              $scope.employee;
              console.log(resp);
        },
        resp => {
            console.error(resp);
        })
}

    $scope.deleteById = function(employee){

         $http.delete("http://localhost:8080/api/v1/employees/" + employee.employeeId)
            .then(resp =>{
                delete $scope.employeesList[employee.employeeId];
            },
            resp => {
               console.error(resp);
            })
    }

});
