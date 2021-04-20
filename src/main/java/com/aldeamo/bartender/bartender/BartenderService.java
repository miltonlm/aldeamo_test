package com.aldeamo.bartender.bartender;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Bartender service that performs the functionality for the endpoint.
 * */
@Service
public class BartenderService {

    /**
     * Hard-coded array of prime numbers. Will not need more values.
     * */
    private final int[] P = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};

    /**
     * Variable to inject the bartender repository to query database.
     * */
    private final BartenderRepository bartenderRepository;

    /**
     * Constructor to inject required components.
     *
     * @param bartenderRepository The repository for the bartend entity.
     * */
    public BartenderService(BartenderRepository bartenderRepository) {
        this.bartenderRepository = bartenderRepository;
    }

    /**
     * Will calculate the values for the algorithm send by Aldeamo's test.
     *
     * @param recordId The record id on the database.
     * @param iterations The number of iterations the system should perform.
     * @return The calculated values joined by a ",".
     * */
    public String calculateValues(long recordId, int iterations) {
        Optional<Bartender> bartender = bartenderRepository.findById(recordId);

        if (bartender.isEmpty()) {
            throw new IllegalStateException(String.format("No record with recordId %d exists.", recordId));
        }

        List<Integer> records = Arrays.stream(bartender.get().getInputArray().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        Set<Integer> R = new LinkedHashSet<>();

        for (int q = 0; q < iterations; q++) {
            List<Integer> recordsLocal = new ArrayList<>(records);
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();

            for (int i = recordsLocal.size(); i > 0; i--) {
                int n = recordsLocal.get(i - 1);

                if (n % P[q] == 0) {
                    B.add(n);
                } else {
                    A.add(n);
                }
            }

            if (!records.isEmpty()) {
                records.remove(0);
            }

            R.addAll(B);
        }

        R.addAll(records);

        return R.stream().map(Object::toString).collect(Collectors.joining(","));
    }

}
