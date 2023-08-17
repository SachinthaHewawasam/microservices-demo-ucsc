package net.saxGuides.employeeservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import net.saxGuides.employeeservice.dto.APIResponseDto;
import net.saxGuides.employeeservice.dto.DepartmenDto;
import net.saxGuides.employeeservice.dto.EmployeeDto;
import net.saxGuides.employeeservice.dto.OrganizationDto;
import net.saxGuides.employeeservice.entity.Employee;
import net.saxGuides.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode(),
                employeeDto.getOrganizationCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode(),
                savedEmployee.getOrganizationCode()
        );
        return savedEmployeeDto;
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        logger.info("inside getEmployeeByID() method");

        Employee employee = employeeRepository.findById(employeeId).get();
//        ResponseEntity<DepartmenDto> deptmtResponseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmenDto.class);
//        DepartmenDto departmenDto = deptmtResponseEntity.getBody();

        DepartmenDto departmenDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmenDto.class)
                .retrieve()
                .bodyToMono(DepartmenDto.class)
                .block();

//        DepartmenDto departmenDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode(), OrganizationDto.class)
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmenDto(departmenDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;
    }

//    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
//        Map<String, Long> anagramMap = new HashMap<>();
//        char[] letters = null;
//        for (String word : wordSet) {
//            Arrays.sort(word.toCharArray());
//            letters = word.toCharArray();
//            String sortedWord = new String(letters);
//            anagramMap.put(sortedWord, anagramMap.getOrDefault(sortedWord, 0L) + 1);
//        }
//
//        List<Long> results = new ArrayList<>();
//        for (String sentence : sentences) {
//            String[] words = sentence.split(" ");
//            long sentenceCount = 1;
//            for (String word : words) {
//                char[] letters = word.toCharArray();
//                Arrays.sort(letters);
//                String sortedWord = new String(letters);
//                sentenceCount *= anagramMap.getOrDefault(sortedWord, 0L);
//            }
//            results.add(sentenceCount);
//        }
//
//        return results;
//    }





    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception){
        logger.info("inside getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmenDto departmenDto = new DepartmenDto();
        departmenDto.setDepartmentName("R &D Department");
        departmenDto.setDepartmentCode("RD001");
        departmenDto.setDepartmentDescription("Research and development dpt");

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmenDto(departmenDto);
        return apiResponseDto;
    }


}
