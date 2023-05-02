package main.main.company.mapper;

import main.main.company.dto.CompanyDto;
import main.main.company.entity.Company;
import main.main.user.entity.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    default Company companyPostToCompany(CompanyDto.Post requestBody) {
        Company company = new Company();
        User user = new User();

        company.setUser(user);
        company.setCompanyName(requestBody.getCompanyName());
        company.setCompanySize(requestBody.getCompanySize());
        company.setBusinessNumber(requestBody.getBusinessNumber());
        company.setAddress(requestBody.getAddress());
        company.setInformation(requestBody.getInformation());

        return company;
    }

    default Company companyPatchToCompany(CompanyDto.Patch requestBody) {
        Company company = new Company();
        User user = new User();

        company.setUser(user);
        company.setCompanyId(requestBody.getCompanyId());
        company.setCompanySize(requestBody.getCompanySize());
        company.setBusinessNumber(requestBody.getBusinessNumber());
        company.setAddress(requestBody.getAddress());
        company.setInformation(requestBody.getInformation());
        company.setCompanyName(requestBody.getCompanyName());


        return company;

    }

    default CompanyDto.Response companyToCompanyResponse(Company company) {
        return CompanyDto.Response.builder()
                .companyId(company.getCompanyId())
                .companyName(company.getCompanyName())
                .companySize(company.getCompanySize())
                .businessNumber(company.getBusinessNumber())
                .address(company.getAddress())
                .information(company.getInformation())
                .userId(company.getUser().getUserId())
                .build();
    }

    default List<CompanyDto.Response> companiesToCompanyResponses(List<Company> companies) {
        return companies.stream()
                .map(company -> companyToCompanyResponse(company))
                .collect(Collectors.toList());
    }
}