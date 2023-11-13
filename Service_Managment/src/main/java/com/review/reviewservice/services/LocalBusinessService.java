package com.review.reviewservice.services;

import com.review.reviewservice.dtos.RatingType;
import com.review.reviewservice.dtos.ServiceDTO;
import com.review.reviewservice.dtos.ServiceType;
import com.review.reviewservice.models.LocalBusiness;
import com.review.reviewservice.repositories.LocalBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocalBusinessService {

    @Autowired
    public LocalBusinessRepository localBusinessRepository;

    public LocalBusiness addServices(ServiceDTO serviceDTO){
        LocalBusiness localBusiness = new LocalBusiness();
        localBusiness.setServiceName(serviceDTO.getServiceName());
        localBusiness.setCity(serviceDTO.getCity());
        localBusiness.setServiceType(serviceDTO.getServiceType());
        localBusiness.setRating(serviceDTO.getRating());
        return localBusinessRepository.save(localBusiness);
    }

    public List<ServiceDTO> getServices(){
        List<ServiceDTO> serviceDTOS = new ArrayList<>();
        localBusinessRepository.findAll().forEach(s -> serviceDTOS.add(new ServiceDTO(s.getServiceName(),s.getServiceType(),s.getCity(),s.getRating())));
        return serviceDTOS;
    }

    public LocalBusiness updateService(Long id,ServiceDTO serviceDTO){
        LocalBusiness localBusiness;
        Optional<LocalBusiness> localBusinessOptional = localBusinessRepository.findById(id);
        if(localBusinessOptional.isEmpty())
            localBusiness = new LocalBusiness();
        else
            localBusiness = localBusinessOptional.get();

        localBusiness.setServiceType(serviceDTO.getServiceType());
        localBusiness.setServiceName(serviceDTO.getServiceName());
        localBusiness.setCity(serviceDTO.getCity());
        return localBusinessRepository.save(localBusiness);
    }

    public void deleteService(Long id){
        Optional<LocalBusiness> localBusinessOptional = localBusinessRepository.findById(id);
        if (localBusinessOptional.isEmpty()){
            throw new IllegalStateException("No such Service Present");
        }
        localBusinessRepository.delete(localBusinessOptional.get());
    }

    public ServiceDTO getServiceById(Long Id) {
        Optional<LocalBusiness> localBusinessOptional = localBusinessRepository.findById(Id);
        if(localBusinessOptional.isEmpty())
            return null;
        else{
            LocalBusiness s = localBusinessOptional.get();
            return new ServiceDTO(s.getServiceName(),s.getServiceType(),s.getCity(),s.getRating());
        }


    }

    public List<ServiceDTO> getByServiceName(String service_name){
        List<ServiceDTO> serviceDTOS = new ArrayList<>();
        localBusinessRepository.findAllByServiceName(service_name).forEach(s -> serviceDTOS.add(new ServiceDTO(s.getServiceName(),s.getServiceType(),s.getCity(),s.getRating())));
        return serviceDTOS;

    }

    public List<ServiceDTO> getByServiceType(ServiceType type){
        List<ServiceDTO> serviceDTOS = new ArrayList<>();
        localBusinessRepository.findAllByServiceType(type).forEach(s -> serviceDTOS.add(new ServiceDTO(s.getServiceName(),s.getServiceType(),s.getCity(),s.getRating())));
        return serviceDTOS;

    }

    public List<ServiceDTO> getByServiceRating(RatingType ratingType){
        List<ServiceDTO> serviceDTOS = new ArrayList<>();
        localBusinessRepository.findAllByRating(ratingType).forEach(s -> serviceDTOS.add(new ServiceDTO(s.getServiceName(),s.getServiceType(),s.getCity(),s.getRating())));
        return serviceDTOS;
    }
}
