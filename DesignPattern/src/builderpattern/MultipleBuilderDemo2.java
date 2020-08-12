package builderpattern;

class Employee2
{
	//personal data
	String firstName,lastName;
	//address data
	String streetAddress,city;
	
	//Job data
	String workLocation,workCity;
	Long annualIncome;
	
	private Employee2() {
		
	}
	
	public static class EmployeeBuilder{
		
		Employee2 employee = new Employee2();
		
		public PersonalBuilder hasDetails()
		{
			return new PersonalBuilder(employee);
		}
		
		public AddressBuilder livesAt()
		{
			return new AddressBuilder(employee);
		}
		
		public JobBuilder worksAt()
		{
			return new JobBuilder(employee);
		}
		
		public Employee2 build() {
			return employee;
		}
	}
	
	public static class PersonalBuilder extends EmployeeBuilder{
		
		public PersonalBuilder(Employee2 employee)
		{
			this.employee =employee;
		}
		
		public PersonalBuilder hasFirstName(String firstName)
		{
			this.employee.firstName=firstName;
			return this;
		}
		
		public PersonalBuilder hasLastName(String lastName)
		{
			this.employee.lastName=lastName;
			return this;
		}
	}
	
    public static class AddressBuilder extends EmployeeBuilder{
		
		public AddressBuilder(Employee2 employee)
		{
			this.employee =employee;
		}
		
		public AddressBuilder address(String address)
		{
			this.employee.streetAddress=address;
			return this;
		}
		
		public AddressBuilder city(String city)
		{
			this.employee.city=city;
			return this;
		}
	}
    
   public static class JobBuilder extends EmployeeBuilder{
		
		public JobBuilder(Employee2 employee)
		{
			this.employee =employee;
		}
		
		public JobBuilder workLocation(String location)
		{
			this.employee.workLocation=location;
			return this;
		}
		
		public JobBuilder workCity(String city)
		{
			this.employee.workCity=city;
			return this;
		}
		
		public JobBuilder annualIncome(Long income)
		{
			this.employee.annualIncome=income;
			return this;
		}
	}
}
public class MultipleBuilderDemo2 {

	public static void main(String[] args)
	{
		Employee2 employee = new Employee2.EmployeeBuilder()
							.hasDetails()
								.hasFirstName("Manpreet")
								.hasLastName("Singh")
							.livesAt()
								.address("Amrapali")
								.city("Noida")
							.worksAt()
								.workLocation("mcquarie")
								.workCity("Gurgaon")
								.annualIncome(100000000L)
							.build();
		
		System.out.println(employee);
	}
}
