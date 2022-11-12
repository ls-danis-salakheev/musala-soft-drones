package com.musala.testdrones.danissalakheev.util;

import com.musala.testdrones.danissalakheev.entity.Medication;
import com.musala.testdrones.danissalakheev.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * ONLY for bytes adding into the medication table
 */
@Profile({"test"})
@Component
@RequiredArgsConstructor
public class DataPreparationUtil {

    @Value("${app.test.dummyImage}")
    private String dummyImagePath;

    private final MedicationRepository medicationRepository;

    @PostConstruct
    @Transactional
    public void initTestData() throws IOException {
        byte[] dummyBytes = new ClassPathResource(dummyImagePath).getInputStream().readAllBytes();
        List<Medication> medications = medicationRepository.findAllByImageIsNull();
        medications.forEach(medication -> medication.setImage(dummyBytes));
        medicationRepository.saveAll(medications);
    }
}
