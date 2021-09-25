package com.bridgelabz.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbook.entity.AddressBookEntity;

@Repository
public interface IAdderssBookRepository extends PagingAndSortingRepository<AddressBookEntity,Integer>
{

}
