package com.springboot.h2.mail;


import pl.recruitingWorkflowApp.model.Process;
import pl.recruitingWorkflowApp.repository.ProcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProcessService {

    private final ProcessRepository processRepository;

    public List<Process> getAll() {
        return processRepository.findAll().stream().collect(Collectors.toList());
    }

    public void save(Process process) {
        processRepository.save(process).getId();
    }

    public Process getProcessById(int id) {
        return processRepository.getOne(id);
    }

    public void deleteById(int id) {
        processRepository.delete(getProcessById(id));
    }
}

