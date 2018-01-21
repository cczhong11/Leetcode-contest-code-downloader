public class Solution {
	public List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> contentMap = new HashMap<>();

		for (String path : paths) {
			String[] arr = path.split(" ");
			String dir = arr[0];
			for (int i = 1; i < arr.length; i++) {
				String fwc = arr[i];
				int idx = fwc.indexOf('(');
				String fName = fwc.substring(0, idx);
				String fContent = fwc.substring(idx + 1, fwc.length() - 1);
				if (!contentMap.containsKey(fContent)) {
					contentMap.put(fContent, new ArrayList<String>());
				}
				List<String> fnames = contentMap.get(fContent);
				fnames.add(dir + '/' + fName);
			}
		}

		List<List<String>> result = new ArrayList<>();
		for (Map.Entry<String, List<String>> en : contentMap.entrySet()) {
			if (en.getValue().size() > 1) {
				result.add(en.getValue());
			}
		}
		return result;
	}
}