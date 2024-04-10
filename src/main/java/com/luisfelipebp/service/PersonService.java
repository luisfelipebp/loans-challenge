package com.luisfelipebp.service;

import com.luisfelipebp.models.Loan;
import com.luisfelipebp.models.Loans;
import com.luisfelipebp.models.Person;
import com.luisfelipebp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Optional<Person> getPersonById(Integer id){
        return personRepository.findById(id);
    }

    public Loans savePerson(Person person){
        Loans loans = new Loans();
        loans.setCustomer(person.getName());
        Loan loanPersonal = new Loan("PERSONAL",4);
        Loan loanGuaranteed = new Loan("GUARANTEED",3);
        Loan loanConsignment = new Loan("CONSIGNMENT",2);
        if(person.getIncome() <= 3000.0 || person.getIncome() > 3000.0 && person.getIncome() < 5000 && person.getAge() <= 30 && person.getLocation().equals("SP")){
            loans.getListLoans().add(loanPersonal);
            loans.getListLoans().add(loanGuaranteed);
        }else if(person.getIncome() >= 5000){
            loans.getListLoans().add(loanConsignment);
            loans.getListLoans().add(loanPersonal);
            loans.getListLoans().add(loanGuaranteed);
        }
        personRepository.save(person);
        return loans;
    }
}
