package builderpattern;

class Employee
{
	private final Integer id;
	private final String firstName;
	private final String lastName;
	private final String age;
	private final String address;
	private final String phone;
	private final String mail;
	
	private Employee(EmployeeBuilder employeeBuilder)
	{
		this.id=employeeBuilder.id;
		this.firstName=employeeBuilder.firstName;
		this.lastName=employeeBuilder.lastName;
		this.age=employeeBuilder.age;
		this.address=employeeBuilder.address;
		this.phone=employeeBuilder.phone;
		this.mail=employeeBuilder.mail;
	}
	public static class EmployeeBuilder
	{
		Integer id;
		String firstName;
		String lastName;
		String age;
		String address;
		String phone;
	    String mail;
		
	    
		public EmployeeBuilder(Integer id,String firstName,String lastName,String age)
		{
			this.id=id;
			this.firstName=firstName;
			this.lastName=lastName;
			this.age=age;
		}
		
		public EmployeeBuilder setAddress(String address)
		{
			this.address=address;
			return this;
		}
		
		public EmployeeBuilder setEmail(String email)
		{
			this.mail=email;
			return this;
		}
		
		public EmployeeBuilder setPhone(String phone)
		{
			this.phone=phone;
			return this;
		}
		
		public Employee build()
		{
			return new Employee(this);
		}
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getMail() {
		return mail;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", address=" + address + ", phone=" + phone + ", mail=" + mail + "]";
	}
	
	
}
public class SingleBuilderDemo {

	public static void main(String[] args) {
		Employee e = new Employee.EmployeeBuilder(1, "Deepak", "Nailwal", "23")
				.setAddress("118,pratap -118")
				.setEmail("abc@gmail.com")
				.setPhone("8375936067").build();

		System.out.println(e);
	}

}
