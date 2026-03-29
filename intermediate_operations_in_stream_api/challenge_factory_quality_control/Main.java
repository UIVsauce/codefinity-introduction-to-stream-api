package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PartBatch> batches = List.of(
            new PartBatch("Batch A", List.of("Engine", "Wheel", "Defective Hood")),
            new PartBatch("Batch B", List.of("Headlight", "Wheel", "Steering Wheel")),
            new PartBatch("Batch C", List.of("Hood", "Headlight", "Defective Engine"))
        );

        List<String> qualityParts = batches.stream()
            .flatMap(batch -> batch.getParts().stream())
            .filter(part -> !part.startsWith("Defective"))
            .distinct()
            .toList();

        System.out.println("Quality parts: " + qualityParts);
    }
}

class PartBatch {
    private String batchName;
    private List<String> parts;

    public PartBatch(String batchName, List<String> parts) {
        this.batchName = batchName;
        this.parts = parts;
    }

    public String getBatchName() {
        return batchName;
    }

    public List<String> getParts() {
        return parts;
    }
}