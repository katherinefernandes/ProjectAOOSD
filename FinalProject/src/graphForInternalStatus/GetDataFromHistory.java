package graphForInternalStatus;

import java.util.List;

public interface GetDataFromHistory {
	List<Integer> statusValues(long journeyID);
}
