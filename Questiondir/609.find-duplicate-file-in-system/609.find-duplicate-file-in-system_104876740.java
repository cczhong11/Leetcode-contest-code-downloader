public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths) {
            String[] df = path.split(" ");
            String directory = df[0];
            for(int i = 1; i < df.length; ++ i) {
                String[] fc = df[i].split("\\(|\\)");
                String fileName = fc[0];
                String fileContent = fc[1];
                map.putIfAbsent(fileContent, new ArrayList<>());
                map.get(fileContent).add(directory + "/" + fileName);
            }
        }
        List<List<String>> duplicates = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            if(entry.getValue().size() > 1) {
                duplicates.add(entry.getValue());
            }
        }
        return duplicates;
    }
}