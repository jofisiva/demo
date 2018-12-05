package com.example.demo;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class Enricher {


    public static void main(String[] args){

        List<CustomId> customIdList = new ArrayList();
        List<CustomIdMapping> customIdMappings = new ArrayList();


        customIdList.add(new CustomId("CUSTOMER", "CUSTOMER_ID"));
        customIdList.add(new CustomId("HOUSEHOLD", "HOUSEHOLD_ID"));


       /* CustomIdMapping customIdMapping = new CustomIdMapping(-1L, true, 0, customIdList.get(0));

        CustomIdMapping customIdMapping1 = new CustomIdMapping(1L, true, 1, customIdList.get(1));
        CustomIdMapping customIdMapping2 = new CustomIdMapping(1L, false, 0, customIdList.get(0));
        CustomIdMapping customIdMapping5 = new CustomIdMapping(1L, true, 1, customIdList.get(0));

        CustomIdMapping customIdMapping4 = new CustomIdMapping(11L, true, 0, customIdList.get(1));
        CustomIdMapping customIdMapping3 = new CustomIdMapping(11L, false, 1, customIdList.get(1));*/


        CustomIdMapping customIdMapping = new CustomIdMapping(-1L, true, 0, 3);

        CustomIdMapping customIdMapping1 = new CustomIdMapping(1L, true, 1, 4);
        CustomIdMapping customIdMapping2 = new CustomIdMapping(1L, false, 0, 3);
        CustomIdMapping customIdMapping5 = new CustomIdMapping(1L, true, 1, 3);

        CustomIdMapping customIdMapping4 = new CustomIdMapping(11L, true, 0, 4);
        CustomIdMapping customIdMapping3 = new CustomIdMapping(11L, false, 1, 4);

        customIdMappings.add(customIdMapping);
        customIdMappings.add(customIdMapping1);

        customIdMappings.add(customIdMapping2);
        customIdMappings.add(customIdMapping3);

        customIdMappings.add(customIdMapping4);

        customIdMappings.add(customIdMapping5);

        Operation op = new Operation(customIdMappings, Arrays.asList(-1L,1L,11L));
        op.enricher();


    }

}

class Operation{

    private List<CustomIdMapping> customIdMappings;

    private List<Long> partitons;

    public Operation(List<CustomIdMapping> customIdMappings, List<Long> partitons) {
        this.customIdMappings = customIdMappings;
        this.partitons = partitons;
    }

    public void enricher(){

        customIdMappings.sort(Comparator.comparing(a -> a.getReportTypeId()));

        Map<Long, List<CustomIdMapping>>  result = customIdMappings.stream().collect(groupingBy(CustomIdMapping::getPartitionId));

        Map<Long,List<CustomIdMapping>> result1 = new HashMap<>();


        for(Long key :result.keySet()){
           // System.out.println(result.get(key));
            List<CustomIdMapping> customIdMappings = result.get(key);
            List<CustomIdMapping> listWithoutDuplicates = customIdMappings.stream()
                    .distinct()

                    .collect(Collectors.toList());

          //  System.out.println(listWithoutDuplicates);
            //customIdMappings.removeIf(customIdMapping -> customIdMapping.getTypeid()==3);

           // result1.put(customIdMappings.stream().collect(Collectors.toMap());

        }
        /*Collection<Integer> result1 = customIdMappings.stream()
                .collect(Collectors.toMap(CustomIdMapping::getPartitionId, CustomIdMapping::getReportTypeId, Integer::max))
                .values();*/

//        Collection<CustomIdMapping> result1 = customIdMappings.stream().collect(
//                Collectors.toMap(CustomIdMapping::getPartitionId, Function.identity(),
//                        BinaryOperator.maxBy(Comparator.comparingInt(CustomIdMapping::getTypeid).thenComparing(CustomIdMapping::getIdDefault)))
//        ).values();
//        result.forEach((key, value) -> System.out.println(key + " : " + value));
//        System.out.println("============");
//        System.out.print(result1);
//System.out.print(result.values().stream().filter( r -> result.size()>1).findFirst().get());//forEach(result.entrySet().size()>1);

       /* String[] result = MapOf_words_arrays.values().stream()  // List<String>
                .flatMap(List::stream)                              // String
                .toArray(String[]::new)*/

//result.forEach((k,v) -> v.stream().filter(r->r.getReportTypeId()==1).forEachOrdered(r1-> result.putAll(k,v)));
       // result.forEach((key, value) -> System.out.println(key + " : " + value));

        //result.forEach((key, value) -> System.out.println(key + " : " + value));
        //result.
        //List<CustomIdMapping> customIdMappings1=  result.entrySet().iterator().next().getValue().stream().flatMap().collect(Collectors.toList());

                Collection<CustomIdMapping> customIdMappings= result.values().stream().flatMap(List::stream)
                        .collect(Collectors.toMap(CustomIdMapping::getReportTypeId,  d -> d,
                        (CustomIdMapping x, CustomIdMapping y) -> x == y ? x :y)).values();

                System.out.println(customIdMappings);
               // Map<Long,List<CustomIdMapping>> map = customIdMappings.stream().collect(Collectors.toMap(CustomIdMapping::getReportTypeId));
               // System.out.print(customIdMappings);*/
    }
}
class CustomIdMapping{

    private Long partitionId;

    private Boolean idDefault;

    private Integer reportTypeId;

    private Integer typeid;

    @Override
    public String toString() {
        return "CustomIdMapping{" +
                "partitionId=" + partitionId +
                ", idDefault=" + idDefault +
                ", reportTypeId=" + reportTypeId +
                ", typeid=" + typeid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomIdMapping that = (CustomIdMapping) o;
        return Objects.equals(partitionId, that.partitionId) &&
                Objects.equals(idDefault, that.idDefault) &&
                Objects.equals(reportTypeId, that.reportTypeId) &&
                Objects.equals(typeid, that.typeid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(partitionId, idDefault, reportTypeId, typeid);
    }

    public CustomIdMapping(Long partitionId, Boolean idDefault, Integer reportTypeId, Integer typeid) {
        this.partitionId = partitionId;
        this.idDefault = idDefault;
        this.reportTypeId = reportTypeId;
        this.typeid = typeid;
    }

    public Long getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(Long partitionId) {
        this.partitionId = partitionId;
    }

    public Boolean getIdDefault() {
        return idDefault;
    }

    public void setIdDefault(Boolean idDefault) {
        this.idDefault = idDefault;
    }

    public Integer getReportTypeId() {
        return reportTypeId;
    }

    public void setReportTypeId(Integer reportTypeId) {
        this.reportTypeId = reportTypeId;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
}

class CustomId{

    private String staticId;

    private String label;

    public String getStaticId() {
        return staticId;
    }

    public void setStaticId(String staticId) {
        this.staticId = staticId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomId customId = (CustomId) o;
        return Objects.equals(staticId, customId.staticId) &&
                Objects.equals(label, customId.label);
    }

    @Override
    public int hashCode() {

        return Objects.hash(staticId, label);
    }

    public CustomId(String staticId, String label) {
        this.staticId = staticId;
        this.label = label;
    }

    @Override
    public String toString() {
        return "CustomId{" +
                "staticId='" + staticId + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
