package ru.verlioka.cmf.appservices.tourvauchers.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.verlioka.cmf.appservices.tourvauchers.controllers.HotelReport;
import ru.verlioka.cmf.appservices.tourvauchers.controllers.VoucherReport;
import ru.verlioka.cmf.appservices.tourvauchers.dao.VoucherDao;
import ru.verlioka.cmf.appservices.tourvauchers.models.VouchersEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("voucherService")
public class VoucherServiceImpl extends GenericServiceImpl<VouchersEntity, Long> implements VoucherService{

	VoucherDao dao;
	final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	private static final Logger log = LoggerFactory.getLogger(VoucherService.class);
	
	public VoucherServiceImpl() {
    }

    @Autowired
    public VoucherServiceImpl(VoucherDao voucherDao) {
        super(voucherDao);
        this.dao = voucherDao;
    }


	public VoucherDao getVoucherDao() {
        return dao;
    }


	@SuppressWarnings("unchecked")
	@Override
	public List<HotelReport> getVouchersByRatingHQL(Integer rating) {
		Query query = dao.getEntityManager().createQuery("from VouchersEntity where hotel.rating = :Rating order by hotel.name");
        query.setParameter("Rating", rating);
        List<VouchersEntity> temp =  (List<VouchersEntity>) query.getResultList();
        return temp.stream()
                .map(voucher -> {
                    HotelReport result = new HotelReport();
                    result.setName(voucher.getHotel().getName());
                    result.setCountry(voucher.getHotel().getCountry().getName());
                    result.setSeaside(voucher.getHotel().getSeaside());
                    result.setStartDate(df.format(voucher.getStart()));
                    result.setFinishDate(df.format(voucher.getFinish()));
                    result.setCost(voucher.getCost());
                    return result;
                })
                .collect(Collectors.toList());
	}

	@Override
	public List<VoucherReport> getAllMidMonthsVouchersCRI(Integer startMonth, Integer finishMonth) {
		return getVoucherDao().getAll()
                .stream()
                .map(obj -> (VouchersEntity) obj)
                .filter(voucher -> (startMonth <= voucher.getStartMonth() && voucher.getFinishMonth() <= finishMonth))
                .map(voucher -> {
                	VoucherReport report = new VoucherReport();
                	report.setCountry(voucher.getHotel().getCountry().getName());
                	report.setRating(voucher.getHotel().getRating());
                	report.setSeaside(voucher.getHotel().getSeaside());
                	report.setStartDate(voucher.getStart());
                    return report;
                })
                .sorted(Comparator.comparing(VoucherReport::getStartDate))
                .collect(Collectors.toList());
	}

	@Override
	public List<HotelReport> getVouchersByRatingCRI(Integer rating) {
		return getVoucherDao().getAll()
                .stream()
                .map(obj -> (VouchersEntity) obj)
                .filter(voucher -> (rating == voucher.getHotel().getRating()))
                .map(voucher -> {
                	HotelReport result = new HotelReport();
                    result.setName(voucher.getHotel().getName());
                    result.setCountry(voucher.getHotel().getCountry().getName());
                    result.setSeaside(voucher.getHotel().getSeaside());
                    result.setStartDate(df.format(voucher.getStart()));
                    result.setFinishDate(df.format(voucher.getFinish()));
                    result.setCost(voucher.getCost());
                    return result;
                })
                .sorted(Comparator.comparing(HotelReport::getName))
                .collect(Collectors.toList());
	}

	@Override
	public List<VoucherReport> getAllMidMonthsVouchersHQL(Integer startMonth, Integer finishMonth) {
		Query query = dao.getEntityManager().createQuery("from VouchersEntity");
		List<VouchersEntity> temp =  (List<VouchersEntity>) query.getResultList();
		return temp.stream()
				.map(obj -> (VouchersEntity) obj)
                .filter(voucher -> (startMonth <= voucher.getStartMonth() && voucher.getFinishMonth() <= finishMonth))
                .map(voucher -> {
                	VoucherReport report = new VoucherReport();
                	report.setCountry(voucher.getHotel().getCountry().getName());
                	report.setRating(voucher.getHotel().getRating());
                	report.setSeaside(voucher.getHotel().getSeaside());
                	report.setStartDate(voucher.getStart());
                    return report;
                })
                .sorted(Comparator.comparing(VoucherReport::getStartDate))
                .collect(Collectors.toList());
	}


	
	
}
