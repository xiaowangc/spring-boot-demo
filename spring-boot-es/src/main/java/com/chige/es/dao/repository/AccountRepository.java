package com.chige.es.dao.repository;

import com.chige.es.domain.ESAccountDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AccountRepository extends ElasticsearchRepository<ESAccountDO, Integer> {
}
