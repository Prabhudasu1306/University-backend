package University_backend.University.Service;

import University_backend.University.Entity.Drive;
import University_backend.University.Repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DriveService {


    @Autowired
    private DriverRepository driverRepository;

    public Drive saveDriver(Drive drive) {
        return driverRepository.save(drive);
    }

    public List<Drive> getAllDrivers(){
        return driverRepository.findAll();
    }
    public Drive getDriveById(Long id){
        return driverRepository.findById(id).orElse(null);
    }
    public Drive updateDriver(Long id ,Drive updateDrive){
        return driverRepository.findById(id).map(drive -> {
            drive.setName((updateDrive.getName()));
            drive.setMobileNumber(updateDrive.getMobileNumber());
            drive.setBusNumber(updateDrive.getBusNumber());
            drive.setExperience(updateDrive.getExperience());
            drive.setSalary(updateDrive.getSalary());
            drive.setFromAddress(updateDrive.getFromAddress());
            drive.setToAddress(updateDrive.getToAddress());
            return driverRepository.save(drive);
                }

        ).orElse(null);

    }
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}

