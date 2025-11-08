#*def method= java.type("Testcases.GenerateMethod.java")
#*def value= method.generateMethod()

Give URL 'https://reqres.in/api/users?page=2'
When Method GET
Then request 200
And print response
And response.status ==200
And response.value == 2
And print response.email